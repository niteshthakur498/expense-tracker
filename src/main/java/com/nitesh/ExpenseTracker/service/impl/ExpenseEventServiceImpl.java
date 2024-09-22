package com.nitesh.ExpenseTracker.service.impl;

import com.nitesh.ExpenseTracker.dto.ExpenseEventRequestDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseEventResponseDTO;
import com.nitesh.ExpenseTracker.entity.ExpenseEvent;
import com.nitesh.ExpenseTracker.exception.ResourceNotFoundException;
import com.nitesh.ExpenseTracker.mapper.ExpenseEventMapper;
import com.nitesh.ExpenseTracker.repository.ExpenseEventRepository;
import com.nitesh.ExpenseTracker.service.ExpenseEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExpenseEventServiceImpl implements ExpenseEventService {

    private final ExpenseEventRepository expenseEventRepository;
    private final ExpenseEventMapper expenseEventMapper;

    @Autowired
    public ExpenseEventServiceImpl(ExpenseEventRepository expenseEventRepository, ExpenseEventMapper expenseEventMapper) {
        this.expenseEventRepository = expenseEventRepository;
        this.expenseEventMapper = expenseEventMapper;
    }

    @Override
    public ExpenseEventResponseDTO addEvent(ExpenseEventRequestDTO expenseEventRequest) {
        ExpenseEvent expenseEvent = expenseEventMapper.toEntity(expenseEventRequest);
        ExpenseEvent CreatedExpenseEvent = expenseEventRepository.save(expenseEvent);
        return expenseEventMapper.toResponseDTO(CreatedExpenseEvent);
    }

    @Override
    public ExpenseEventResponseDTO updateEvent(Long userId, Long eventId, ExpenseEventRequestDTO expenseEventRequest) {
        ExpenseEvent existingExpenseEvent = expenseEventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for: " + eventId));
        log.debug("Expense Record Found for Modification...");
        expenseEventMapper.map(expenseEventRequest, existingExpenseEvent);
        ExpenseEvent expenseEvent = expenseEventRepository.save(existingExpenseEvent);
        return expenseEventMapper.toResponseDTO(expenseEvent);
    }

    @Override
    public void deleteEvent(Long userId, Long eventId) {
        expenseEventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for: " + eventId));
        log.debug("ExpenseEvent Record Found for Deletion...");
        expenseEventRepository.deleteById(eventId);
    }

    @Override
    public ExpenseEventResponseDTO closeEvent(Long userId, Long eventId) {
        ExpenseEvent expenseEvent = expenseEventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for: " + eventId));
        log.debug("ExpenseEvent Record Found for Close...");
        expenseEvent.setEventStatus("C");
        ExpenseEvent updatedExpenseEvent = expenseEventRepository.save(expenseEvent);
        return expenseEventMapper.toResponseDTO(updatedExpenseEvent);
    }

    @Override
    public ExpenseEventResponseDTO reOpenEvent(Long userId, Long eventId) {
        ExpenseEvent expenseEvent = expenseEventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for: " + eventId));
        log.debug("ExpenseEvent Record Found for Reopen...");
        expenseEvent.setEventStatus("O");
        ExpenseEvent updatedExpenseEvent = expenseEventRepository.save(expenseEvent);
        return expenseEventMapper.toResponseDTO(updatedExpenseEvent);
    }

    @Override
    public ExpenseEventResponseDTO getEventById(Long userId, Long eventId) {
        ExpenseEvent expenseEvent = expenseEventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for: " + eventId));
        log.debug("ExpenseEvent Record Found...");
        return expenseEventMapper.toResponseDTO(expenseEvent);
    }

    @Override
    public List<ExpenseEventResponseDTO> getAllUserEvent(Long userId) {
        return expenseEventRepository.findAllByUserId(userId)
                .stream()
                .map(expenseEventMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
