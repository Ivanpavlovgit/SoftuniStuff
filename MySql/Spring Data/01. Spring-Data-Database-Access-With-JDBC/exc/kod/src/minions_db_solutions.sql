/*
//Execute sql file that was given to you
//Write a program that prints on the console all villains’
 names and their number of minions.
// Get only the villains who have more than 15 minions.
// Order them by number of minions in descending order.
*/
SELECT 
    v.`name`, COUNT(m.`id`) AS `count_minion_army`
FROM
    `villains` AS v
        LEFT JOIN
    `minions_villains` AS mv ON v.`id` = mv.`villain_id`
        LEFT JOIN
    `minions` AS m ON mv.`minion_id` = m.`id`
GROUP BY v.`id`
HAVING `count_minion_army`>15
ORDER BY `count_minion_army` DESC;

/*
2.	Get Minion Names
Write a program that prints on the console all 
minion names and their age for given villain id. 
For the output, use the formats given in the examples.
*/

SELECT 
    v.`name`, m.`name`, m.`age`
FROM
    `minions` AS m
        JOIN
    `minions_villains` AS mv ON m.`id` = mv.`minion_id`
        JOIN
    `villains` AS v ON mv.`villain_id` = v.`id`
WHERE
    v.`id` = 3
ORDER BY v.`name`;