package lt.techin.demo.service;

import lt.techin.demo.model.RunningEvent;
import lt.techin.demo.repository.RunningEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RunningEventService {

  private final RunningEventRepository runningEventRepository;

  public RunningEventService(RunningEventRepository runningEventRepository) {
    this.runningEventRepository = runningEventRepository;
  }

  public RunningEvent saveRunningEvent(RunningEvent runningEvent) {
    return runningEventRepository.save(runningEvent);
  }

  public List<RunningEvent> findAllRunningEvent() {
    return runningEventRepository.findAll();
  }

  public Optional<RunningEvent> findRunningEventById(long id) {
    return runningEventRepository.findById(id);
  }

  public boolean existsRunningEventById(long id) {
    return runningEventRepository.existsById(id);
  }

  public void deleteRunningEventById(long id) {
    runningEventRepository.deleteById(id);
  }
}
