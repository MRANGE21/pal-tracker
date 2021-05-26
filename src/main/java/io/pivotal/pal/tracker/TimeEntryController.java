package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping(path = "/timeEntry")
public class TimeEntryController {

    private final TimeEntryRepository timeEntryRepository ;
    private TimeEntry timeEntryToCreate;

    @Autowired
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(timeEntry, HttpStatus.CREATED);
        //return null;

    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long nonExistentTimeEntryId) {
        TimeEntry nonExistentTime = timeEntryRepository.find(nonExistentTimeEntryId);
        return new ResponseEntity<>(nonExistentTime, HttpStatus.OK);
        //return null;
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
        //return null;
    }

    @PutMapping("{id|timeEntry}")
    public ResponseEntity<TimeEntry> update(@RequestBody long timeEntryId, TimeEntry timeEntryToUpdate) {
        TimeEntry updateTime = timeEntryRepository.update(timeEntryId,timeEntryToUpdate);
        return new ResponseEntity<>(updateTime, HttpStatus.OK);
        //return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(long timeEntryId) {
        return new ResponseEntity(timeEntryId, HttpStatus.OK);
        //return null;
    }
}
