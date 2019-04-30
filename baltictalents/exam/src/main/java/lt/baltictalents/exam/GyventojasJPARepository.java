package lt.baltictalents.exam;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GyventojasJPARepository extends JpaRepository<Gyventojas, Long> {
    @Query("SELECT g FROM gyventojas g WHERE g.id = :id")
    Gyventojas getById(@Param("id") Long id);
}