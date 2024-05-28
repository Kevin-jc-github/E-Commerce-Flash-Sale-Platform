# Interactive Flash Sale System

This project demonstrates a highly concurrent interactive flash sale system. The system is optimized to handle high traffic, ensure data consistency, and provide a seamless user experience during flash sales events.

## Project Highlights

### High Concurrency Handling
- **Rate Limiting and Circuit Breaking**: Implemented using Alibaba’s Sentinel framework to control traffic flow and break circuits, ensuring system stability and high availability during peak loads.
- **Distributed Transaction Processing**: Utilized RocketMQ for distributed transactions, ensuring data consistency under high concurrency.

### System Optimization
- **Cache Warming**: Used Redis for caching to pre-warm the flash sale product details page, significantly reducing database load and improving response times.
- **CDN Acceleration**: Optimized content delivery using CDN technology to enhance user access speed.
- **Page Staticization**: Converted dynamically generated HTML pages to static content and deployed them on Nginx servers, significantly enhancing the system’s concurrent handling capabilities&#8203;:citation.

### Order and Inventory Management
- **Order Module**: Designed and implemented order creation, order status management, and order message processing mechanisms. Used the Snowflake algorithm to generate unique order IDs, ensuring uniqueness and efficiency in a distributed system&#8203;:citation.
- **Inventory Management**: Utilized Redis and Lua scripts to manage inventory deductions and prevent overselling, ensuring consistency and accuracy of inventory data under high concurrency.

### Data Consistency Handling
- **Delayed Message Queue**: Used RocketMQ’s delayed message mechanism to close timeout orders, ensuring timely order processing and data consistency.

## Technologies Used
- **Framework**: SpringBoot，MyBatis
- **Database**: MySQL
- **Cache Middleware**: Redis
- **Message Middleware**: RocketMQ
- **Flow Control**: Sentinel from Alibaba
- **Frontend Technologies**: Thymeleaf, CDN, CSS, HTML5, JavaScript

## Project Outcomes
- Developed a robust flash sale system capable of handling tens of thousands of requests per second.
- Significantly improved system response times and user experience through multi-layered optimization techniques.
- Enhanced order processing and inventory management modules, effectively resolving overselling issues and managing order states.


