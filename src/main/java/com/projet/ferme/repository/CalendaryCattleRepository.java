package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projet.ferme.entity.CalendaryCattle;
@CrossOrigin("*")
public interface CalendaryCattleRepository extends JpaRepository<CalendaryCattle,Long>{

	List<CalendaryCattle> findByCattle_id(Long id);

}
