package team.lunch.planner.team.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface TeamEntityRepository extends JpaRepository<TeamEntity, Long> {
    
}
