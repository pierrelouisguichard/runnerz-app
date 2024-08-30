package com.runnerz.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RunRepository {

    private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("select * from run")
                .query(Run.class)
                .list();
    }
}

//@Repository
//public class RunRepository {
//    private List<Run> runs = new ArrayList<>();
//
//    List<Run> findAll() {
//        return runs;
//    }
//
//    Optional<Run> findById(Integer id) {
//        return runs.stream().filter(run -> run.id() == id).findFirst();
//    }
//
//    void create(Run run) {
//        runs.add(run);
//    }
//
//    void update(Run run, Integer id) {
//        Optional<Run> existingRun = findById(id);
//        if (existingRun.isPresent()) {
//            runs.set(runs.indexOf(existingRun.get()), run);
//        }
//    }
//
//    void delete(Integer id) {
//        runs.removeIf(run -> run.id().equals(id));
//    }
//
//    @PostConstruct
//    private void init() {
//        runs.add(new Run(1, "First Run", 5, 5));
//        runs.add(new Run(2, "Second Run", 15, 15));
//    }
//}
