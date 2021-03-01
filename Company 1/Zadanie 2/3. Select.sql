SELECT date(time) AS 'Dzień', min(time) AS 'Wschód', max(time) AS 'Zachód'
FROM temp
WHERE measurement IS NOT NULL
GROUP BY day(time)
