package lt.techin.demo.dto;


import lt.techin.demo.model.RunningEvent;

import java.util.List;

public class RunningEventMapper {

  public static List<RunningEventRequestDTO> toRunningEventRequestDTOList(List<RunningEvent> runningEvents) {
    List<RunningEventRequestDTO> result = runningEvents.stream()
            .map(runningEvent -> new RunningEventRequestDTO(runningEvent.getName(), runningEvent.getCalendarDate(), runningEvent.getLocation(), runningEvent.getMaxParticipants()))
            .toList();
    return result;
  }

  public static RunningEventRequestDTO toRunningEventRequestDTO(RunningEvent runningEvent) {
    return new RunningEventRequestDTO(runningEvent.getName(), runningEvent.getCalendarDate(), runningEvent.getLocation(), runningEvent.getMaxParticipants());
  }

  public static RunningEvent toRunningEvent(RunningEventRequestDTO runningEventRequestDTO) {
    RunningEvent runningEvent = new RunningEvent();
    runningEvent.setName(runningEventRequestDTO.name());
    runningEvent.setCalendarDate(runningEventRequestDTO.calendarDate());
    runningEvent.setLocation(runningEventRequestDTO.location());
    runningEvent.setMaxParticipants(runningEventRequestDTO.maxParticipants());
    return runningEvent;
  }

  public static List<RunningEventResponseDTO> toRunningEventResponseDTOList(List<RunningEvent> runningEvents) {
    List<RunningEventResponseDTO> result = runningEvents.stream()
            .map(runningEvent -> new RunningEventResponseDTO(runningEvent.getId(), runningEvent.getName(), runningEvent.getCalendarDate(), runningEvent.getLocation(), runningEvent.getMaxParticipants()))
            .toList();
    return result;
  }

  public static RunningEventResponseDTO toRunningEventResponseDTO(RunningEvent runningEvent) {
    return new RunningEventResponseDTO(runningEvent.getId(), runningEvent.getName(), runningEvent.getCalendarDate(), runningEvent.getLocation(), runningEvent.getMaxParticipants());
  }

  public static RunningEvent toRunningEvent(RunningEventResponseDTO runningEventResponseDTO) {
    RunningEvent runningEvent = new RunningEvent();
    runningEvent.setName(runningEventResponseDTO.name());
    runningEvent.setCalendarDate(runningEventResponseDTO.calendarDate());
    runningEvent.setLocation(runningEventResponseDTO.location());
    runningEvent.setMaxParticipants(runningEventResponseDTO.maxParticipants());
    return runningEvent;
  }
}
