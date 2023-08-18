package kr.co.seoulit.insa.testdaylabr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DayLaborRepository extends JpaRepository<DayLaborTO,String> {
}
