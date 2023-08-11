package kr.co.seoulit.insa.sys.mapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.WordUtils;
import org.springframework.stereotype.Component;

import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataSetList;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.sys.annotation.ColumnName;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import kr.co.seoulit.insa.sys.annotation.Remove;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DatasetBeanMapper {

    //여러행의 정보를 받아놀때
    //~~~~여러개의 데이터 받아온다.
    public <T> List<T> datasetToBeans(PlatformData reqData, Class<T> classType) throws Exception {
        String datasetName = getDataSetName(classType);
        //datasetName은 TO클래스 위에 @Dataset(name= "")으로 지정된 이름
        log.info("datasetName:"+datasetName);
        DataSet dataset = reqData.getDataSet(datasetName);
        // 그 이름으로 지정된 view단에서 날라온 dataset 찾는다. ex) name=gds_company
        log.info("dataset:"+dataset);
        List<T> beanList = new ArrayList<T>();
        log.info("beanList:"+beanList);
        T bean = null;
        int rowCount = dataset.getRowCount(); // xml로 날라온 rowCount를 구한다. 즉 한 개의 행


        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) { // 데이터의 행만큼 돌면서 아래 진행,  2개면 0, 1
            bean = getBean(dataset, classType, rowIndex); // 데이터를 set 다해준 bean을 리턴 받았다.
            beanList.add(bean); // 그리고 여러개의 bean을 list에 넣어주고 return 해준다.
            log.info("beanList:"+beanList);
        }

        rowCount = dataset.getRemovedRowCount();
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            bean = getDeletedBean(dataset, classType, rowIndex);
            beanList.add(bean);
        }
        return beanList;
    }

    public <T> T datasetToBean(PlatformData reqData, Class<T> classType) throws Exception {
        T bean = null;
        String datasetName = getDataSetName(classType);
        log.info("datasetName:"+datasetName);
        DataSet dataset = reqData.getDataSet(datasetName);

        if(dataset.getRemovedRowCount() == 0)
            bean = getBean(dataset, classType, 0);
        else
            bean = getDeletedBean(dataset, classType, 0);

        return bean;
    }

    //list에 담긴 bean객체를  dataset으로 처리
    public <T> void beansToDataset(PlatformData resData, List<T> beanList, Class<T> classType) throws Exception {
        Map<String, String> nameMap = new HashMap<String, String>();// 칼럼이름을 담고 칼럼value를 구할때 필요

       DataSetList datasetList = resData.getDataSetList(); // 여러값이 담길때는 DataSetList 사용 한개는 dataset

        String datasetName = getDataSetName(classType); // TO위에 있는 @Dataset(name= "")의 name value값을 얻어옴.
        log.info("datasetName:"+datasetName);
        DataSet dataset = new DataSet(datasetName);// Dataset에 ex) gds_estimate 이름으로 변수 등록 view단에서 gds_estimate의 변수이름으로

       datasetList.add(dataset);// 추가

        Field[] fields = classType.getDeclaredFields(); // TO에 선언된 멤버변수들을 가져온다.
        for(Field field : fields)
            setColumnName(dataset, nameMap, field); // dataset Column에 할당 작업
        for(T bean : beanList)
            setColumnValue(dataset, nameMap, bean); // dataset에 할당 작업
    }


    public <T> void beanToDataset(PlatformData resData, T bean, Class<T> classType) throws Exception {
        Map<String, String> nameMap = new HashMap<String, String>();
        DataSetList datasetList = resData.getDataSetList();

        String datasetName = getDataSetName(classType);
        DataSet dataset = new DataSet(datasetName);

        datasetList.add(dataset);

        if(bean != null) {

        	Field[] fields = classType.getDeclaredFields();

            for(Field field : fields)
                setColumnName(dataset, nameMap, field);

            setColumnValue(dataset, nameMap, bean);
        }
    }

    public void mapToDataset(PlatformData resData, List<Map<String, Object>> mapList, String datasetName) throws Exception {
        DataSetList datasetList = resData.getDataSetList();
        DataSet dataset = new DataSet(datasetName);
        datasetList.add(dataset);

        for(String key : mapList.get(0).keySet()) {
            String columnName = key.toLowerCase();
            dataset.addColumn(columnName, DataTypes.STRING, 256);
        }

        int rowIndex = 0;
        for(Map<String, Object> map : mapList) {
            rowIndex = dataset.newRow();
            for(String key : map.keySet()) {
                Object columnValue = map.get(key);
                dataset.set(rowIndex, key.toLowerCase(), columnValue);
            }
        }
    }

    public List<Map<String, Object>> datasetToMap(PlatformData reqData, String datasetName) throws Exception {
        List<Map<String, Object>> mapList = new ArrayList<>();

        DataSet dataset = reqData.getDataSet(datasetName);
        int rowCount = dataset.getRowCount();
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", dataset.getRowTypeName(rowIndex));

            for(int colIndex = 0; colIndex < dataset.getColumnCount(); colIndex++) {
                String key = dataset.getColumn(colIndex).getName();
                Object value = dataset.getObject(rowIndex, key);
                map.put(formattingToCamel(key), value);
            }
            mapList.add(map);
        }

        rowCount = dataset.getRemovedRowCount();
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", dataset.getRowTypeName(rowIndex));

            for(int colIndex = 0; colIndex < dataset.getColumnCount(); colIndex++) {
                String key = dataset.getColumn(colIndex).getName();
                Object value = dataset.getObject(rowIndex, key);
                map.put(formattingToCamel(key), value);
            }
            mapList.add(map);
        }
        return mapList;
    }

    private <T> String getDataSetName(Class<T> classType) {
        if(classType.isAnnotationPresent(Dataset.class))
            return classType.getAnnotation(Dataset.class).name();
        else
            return "ds" + classType.getName().replace("To", "");
    }

    private String getColumnName(Method method) {
        String columnName = null;
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof ColumnName) {
                String annotaionName = ((ColumnName) annotation).name();
                columnName = annotaionName;
            }
        }
        if (annotations.length == 0)
            columnName = formattingToSnake(method.getName());
        return columnName;
    }

    //view단으로 가져가기위해 Dataset에 셋팅작업
    private void setColumnName(DataSet dataset, Map<String, String> nameMap, Field field) {
        	ColumnName column = field.getAnnotation(ColumnName.class);// filed(멤버변수)에 @CoulmnName로 선언된 것을 가져온다. jpa
            //현재 사용하지 않아서 null나옴

            Remove remove = field.getAnnotation(Remove.class);// Bean Class를 DataSet으로 변환 하지 않을 애들을 위해 맵
            //List<EstimateDetailTo> estimateDetailTOList 이런애들은 제거 되있음
            if(column != null) {
                dataset.addColumn(column.name(), getDataType(field));// view단으로 날아갈 dataset에 칼럼 이름과 타입()을 지정해준다.
                nameMap.put(column.name(), field.getName());// 맵에는 칼럼이름(ColumnName에 지정한), 칼럼이름
            } else if(column == null && remove == null) {
                String columnName = formattingToSnake(field.getName());// view단에 설정된 칼럼이름으로 변경작업 ex) ABC_AAA
                dataset.addColumn(columnName, getDataType(field));// dataset의 칼럼이름(view단의 DataSet의 칼럼 이름과 같음), 타입 셋팅완료(view)
                nameMap.put(columnName, field.getName());// view값 구하기 위해 map에 넣어준다.
            }
    }

    private <T> void setColumnValue(DataSet dataset, Map<String, String> nameMap, T bean) throws Exception {
        int rowIndex = dataset.newRow();

        for(String columnName : nameMap.keySet()) {
            String fieldName = nameMap.get(columnName);
            Field value = bean.getClass().getDeclaredField(fieldName.trim());
            value.setAccessible(true);									// Priavte 로 되어있는 객체에 접근하기 위해서 사용
            dataset.set(rowIndex, columnName, value.get(bean));			// 값을 얻기 위해서 사용
        }
    }

    private <T> T getBean(DataSet dataset, Class<T> classType, int rowIndex) throws Exception {
        T bean = classType.newInstance();
        Method[] methods = classType.getDeclaredMethods();
        Method statusMethod = classType.getMethod("setStatus", String.class);
        String rowType = null;

        switch(dataset.getRowTypeName(rowIndex)){
        	case "inserted" :

        		rowType = "insert";
        		break;
        	case "updated" :

        		rowType = "update";
        		break;
        }
        statusMethod.invoke(bean, rowType);
        for(Method method : methods) {
            if(method.getName().startsWith("set")) {
                String columnName = getColumnName(method);

                if(columnName != null) {
                    Object columnValue = dataset.getObject(rowIndex, columnName);

                    if(columnValue != null)
                        method.invoke(bean, columnValue);
                }
            }
        }
        return bean;
    }
    private <T> T getDeletedBean(DataSet dataset, Class<T> classType, int rowIndex) throws Exception {
        T bean = classType.newInstance();
        Method[] methods = classType.getDeclaredMethods();
        Method statusMethod = classType.getMethod("setStatus", String.class);
        statusMethod.invoke(bean, "delete");
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                String columnName = getColumnName(method);
                if (columnName != null) {
                    Object columnValue = dataset.getRemovedData(rowIndex, columnName);
                    if (columnValue != null)
                        method.invoke(bean, columnValue);
                }
            }
        }
        return bean;
    }
    private int getDataType(Field field) {
        Class<?> returnType = field.getType();
        if(returnType == Date.class)
            return DataTypes.DATE;
        else if(returnType == String.class)
            return DataTypes.STRING;
        else if(returnType == int.class || returnType == boolean.class)
            return DataTypes.INT;
        else if(returnType == BigDecimal.class)
            return DataTypes.BIG_DECIMAL;
        else if(returnType == double.class )
            return DataTypes.DOUBLE;
        else if(returnType == byte[].class)
            return DataTypes.BLOB;
        else
            return DataTypes.NULL;
    }

    private String formattingToSnake(String name) {
        String regex = "([a-z])([A-Z])";
        String replacement = "$1_$2";


        if(name.startsWith("set") || name.startsWith("get"))
            name = name.substring(3);
        // aA -> a_A
        name = name.replaceAll(regex, replacement);
        // return A_A
        return name.toUpperCase();

    }

    private String formattingToCamel(String name) {

        if(name.startsWith("set") || name.startsWith("get"))
            name = name.substring(3);
        String camel = WordUtils.capitalizeFully(name, new char[]{'_'}).replaceAll("_", "");
        return camel.substring(0, 1).toLowerCase() + camel.substring(1);
    }

}
