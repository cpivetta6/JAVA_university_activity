package com.caiopivetta6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiopivetta6.domain.Activity;
import com.caiopivetta6.domain.Block;
import com.caiopivetta6.domain.Category;
import com.caiopivetta6.domain.Participant;
import com.caiopivetta6.repositories.ActivityRepository;
import com.caiopivetta6.repositories.BlockRepository;
import com.caiopivetta6.repositories.CategoryRepository;
import com.caiopivetta6.repositories.ParticipantRepository;

@SpringBootApplication
public class UniversityActivityProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UniversityActivityProjectApplication.class, args);
	}
	
	
	@Autowired
	ActivityRepository activityRepository;
	
	@Autowired
	BlockRepository blockRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ParticipantRepository participantRepository;

	@Override
	public void run(String... args) throws Exception, ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		//Participant
		
		Participant participant1 = new Participant(null, "Chiara Bissolo", "chiara@gmail.com");
		Participant participant2 = new Participant(null, "Monica Bissolo", "Monica@gmail.com");
		Participant participant3 = new Participant(null, "Max Bissolo", "Max@gmail.com");
		
		
		
		//BLOCK
		
		Block block1 = new Block(null, sdf.parse("22/02/2023").toInstant(), sdf.parse("24/02/2023").toInstant());
		
		
		//CATEGORY
		
		Category category1 = new Category(null, "Science and tech");
		categoryRepository.save(category1);
		
	
		//ACTIVITY
		
		Activity activity = new Activity(null, "A.I the future", "WorkShop of A.I tech and new features", 60.0);
		
		activity.getParticipants().addAll(Arrays.asList(participant1, participant2, participant3));
		activity.getBlocks().add(block1);
		activity.setCategory(category1);
		
		activityRepository.save(activity);
		
		//BLOCK, PARTICIPANT AND CATEGORY -> ACTIVITY
		
		
		participant1.setActivity(activity);
		participant2.setActivity(activity);
		participant3.setActivity(activity);
		
		block1.setActivity(activity);
		
		category1.getActivities().add(activity);
		
		blockRepository.save(block1);
		participantRepository.saveAll(Arrays.asList(participant1, participant2, participant3));
	}

	
	
}
