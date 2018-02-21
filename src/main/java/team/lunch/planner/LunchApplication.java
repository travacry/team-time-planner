package team.lunch.planner;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import team.lunch.planner.team.domain.Lunch;
import team.lunch.planner.team.domain.Team;
import team.lunch.planner.team.domain.TeamRepository;
import team.lunch.planner.user.domain.User;
import com.google.common.collect.Lists;

@SpringBootApplication
public class LunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunchApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeData(TeamRepository teamRepository) {
        return args -> {
//            List<User> members = Lists.newArrayList(
//                    new User(null, "Amanda", "Svensson Köhler"),
//                    new User(null, "André", "Schreck"),
//                    new User(null, "Jens", "Voges"),
//                    new User(null, "Nico", "Schober"),
//                    new User(null, "Matthias", "Müller"),
//                    new User(null, "Cuong", ""),
//                    new User(null, "Anika", "Bracht"),
//                    new User(null, "Olena", "Tretyak"),
//                    new User(null, "Christoph", "Klaas"),
//                    new User(null, "Michael", "Bagdahn"));
//            members.get(0).setTurn(true);
//            members.get(0).setPresent(true);
//
//            Team crazyCrabs = new Team(null, "Crazy Crabs", members, new Lunch(null, "TAV"));
//            teamRepository.save(crazyCrabs);
            //
            //			Lunch lunch = new Lunch(null, Collections.emptyList());
            //			Team team = teamRepository.determineTeam("Crazy Crabs");
            //			crazyCrabs = new Team(team.getId(), team.getName(), team.getMembers(), lunch);
            //			teamRepository.save(crazyCrabs);
        };
    }
}
