package com.example.BMS.services;

import com.example.BMS.exception.SeatSelectionException;
import com.example.BMS.exception.ShowNorFoundException;
import com.example.BMS.exception.UserNotFoundException;
import com.example.BMS.model.*;
import com.example.BMS.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private SeatRepository seatRepository;
    private ShowSeatRepository showSeatRepository;
    private SeatTypeShowRepository seatTypeShowRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(UserRepository userRepository, ShowRepository showRepository, SeatRepository seatRepository, ShowSeatRepository showSeatRepository, SeatTypeShowRepository seatTypeShowRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
        this.seatTypeShowRepository = seatTypeShowRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket bookTicket(int userId, List<Integer> showSeatIds) throws UserNotFoundException, SeatSelectionException {
        // Get users

        User user = userRepository.findById(userId).orElseThrow(() ->new UserNotFoundException(String.format("No user is found with id: %s",userId)));

        // Get seats

        List<ShowSeat> showSeats = checkAndBlock(user,showSeatIds);

        List<Seat> seats = showSeats.stream().map(ShowSeat::getSeat).toList();

        Show show = showSeats.get(0).getShow();

        List<SeatTypeShow> seatTypeShows = seatTypeShowRepository.findByShow(show);

        Map<SeatType,Double> priceMap = new EnumMap<>(SeatType.class);

        for(SeatTypeShow seatTypeShow: seatTypeShows){
            priceMap.put(seatTypeShow.getSeatType(),seatTypeShow.getPrice());
        }

        double price =0;
        for(ShowSeat seat: showSeats){
            price += priceMap.get(seat.getSeat().getSeatType());
        }

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setShow(showSeats.get(0).getShow());
        ticket.setSeats(seats);
        ticket.setPrice(price);

        return ticketRepository.save(ticket);


    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> checkAndBlock(User user,List<Integer> showSeatIds) throws SeatSelectionException {
        List<ShowSeat> showSeats = showSeatRepository.findByIdInAndSeatStatus_Available(showSeatIds);

        if(showSeatIds.size() > showSeats.size()){
            // TODO: Add logic to find the booked seats.
            throw new SeatSelectionException("Some seats are already booked.");
        }

        showSeats.forEach(showSeat->{
            showSeat.setUser(user);
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
        });

        showSeatRepository.saveAll(showSeats);
        return showSeats;
    }
}
