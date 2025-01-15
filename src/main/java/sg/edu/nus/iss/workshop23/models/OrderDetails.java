package sg.edu.nus.iss.workshop23.models;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class OrderDetails implements Serializable{
    private Integer id;
    private DateTime orderDate;
    private Integer customerId;
    private Double totalPrice;
    private Double discountedPrice;
    private Double costPrice;

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(DateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public static OrderDetails create(SqlRowSet rs){
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(rs.getInt("order_id"));
        orderDetails
            .setOrderDate(
                new DateTime(
                    DateTimeFormat.forPattern("dd/MM/yyyy")
                    .parseDateTime(rs.getString("order_date"))));
        orderDetails.setCustomerId(rs.getInt("customer_id"));
        orderDetails.setTotalPrice(rs.getDouble("total_price"));
        orderDetails.setDiscountedPrice(
                rs.getDouble("discounted_price"));
        orderDetails.setCostPrice(rs.getDouble("cost_price"));
        return orderDetails;
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
            .add("order_id", id)
            .add("order_date", orderDate.toString("dd/MM/yyyy"))
            .add("customer_id", customerId)
            .add("discounted_price", getDiscountedPrice().toString())
            .add("cost_price", getCostPrice().toString())
            .build();
    }

}
