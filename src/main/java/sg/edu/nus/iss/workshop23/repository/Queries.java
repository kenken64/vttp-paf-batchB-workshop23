package sg.edu.nus.iss.workshop23.repository;

public class Queries {
    public static final String GET_ORDER_DETAILS_WITH_DISCOUNT = """
            SELECT 
                o.id AS order_id,
                DATE_FORMAT(o.order_date, '%d/%m/%Y') AS order_date,
                o.customer_id AS customer_id,
                SUM(od.quantity * od.unit_price) as total_price,
                (SUM(od.quantity * od.unit_price) - SUM(od.quantity * od.unit_price * od.discount)) as discounted_price,
                SUM(od.quantity * p.standard_cost) as cost_price
            FROM orders as o
            LEFT JOIN order_details AS od
                ON o.id = od.order_id
            LEFT JOIN products AS p
                ON od.product_id = p.id
            WHERE o.id = ?
            """;
}
