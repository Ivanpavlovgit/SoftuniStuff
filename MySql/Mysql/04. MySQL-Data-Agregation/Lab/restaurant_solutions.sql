#1.	 Departments Info
#Write a query to count the number of employees in each department by id. 
#Order the information by deparment_id, then by employees count. 
#Submit your queries with the MySQL prepare DB & run queries strategy.

SELECT 
    `department_id`, COUNT(*) AS `count`
FROM
    `employees`
GROUP BY `department_id`
ORDER BY `department_id` , `count`;

#2.	Average Salary
#Write a query to calculate the average salary in each department. 
#Order the information by department_id. 
#Round the salary result to two digits after the decimal point. 
#Submit your queries with the MySQL prepare DB & run queries strategy.

SELECT 
    `department_id`, ROUND(AVG(`salary`), 2) AS 'avg_salary'
FROM
    `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

#3.	 Min Salary
#Write a query to retrieve information about the departments grouped by department_id with minumum salary higher than 800. 
#Round the salary result to two digits after the decimal point. 
#Submit your queries with the MySQL prepare DB & run queries strategy.

SELECT 
    `department_id`, ROUND(MIN(`salary`), 2) AS `min_salary`
FROM
    `employees`
GROUP BY `department_id`
HAVING `min_salary` > 800
ORDER BY `department_id`;

#4.	 Appetizers Count
#Write a query to retrieve the count of all appetizers (category id = 2) with price higher than 8. 
#Submit your queries with the MySQL prepare DB & run queries strategy. 
SELECT 
    COUNT(*) AS `count_appetizers`
FROM
    `products`
WHERE
    `category_id` = 2 AND `price` > 8;
    
#5.Menu Prices
#Write a query to retrieve information about the prices of each category. 
#The output should consist of:
#•	Category_id
#•	Average Price 
#•	Cheapest Product
#•	Most Expensive Product
#See the examples for more information. 
#Round the results to 2 digits after the decimal point. 
#Submit your queries with the MySQL prepare DB & run queries strategy.
 
SELECT 
    `category_id`,
    ROUND(AVG(`price`), 2) AS `avg_price`,
    ROUND(MIN(`price`), 2) AS `cheapest_product`,
    ROUND(MAX(`price`), 2) AS `most_expensive_product`
FROM
    `products`
GROUP BY `category_id`;