package sg.edu.nus.iss.workshop23.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop23.models.OrderDetails;


import static sg.edu.nus.iss.workshop23.repository.Queries.*;

@Repository
public class OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderDetails getOrderDetailsWithDiscount(int orderId) {
        final List<OrderDetails> orderDetails = new LinkedList<>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_ORDER_DETAILS_WITH_DISCOUNT
                            , orderId);

        while(rs.next()){
            orderDetails.add(OrderDetails.create(rs));
        }
        return orderDetails.get(0);
    }
    
}
