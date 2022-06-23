-- -- Create table If Not Exists Weather (Id int, RecordDate date, Temperature int)
-- -- Truncate table Weather
-- -- insert into Weather (Id, RecordDate, Temperature) values ('1', '2015-01-01', '10')
-- -- insert into Weather (Id, RecordDate, Temperature) values ('2', '2015-01-02', '25')
-- -- insert into Weather (Id, RecordDate, Temperature) values ('3', '2015-01-03', '20')
-- -- insert into Weather (Id, RecordDate, Temperature) values ('4', '2015-01-04', '30')
--
-- Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.
--
-- +---------+------------------+------------------+
-- | Id(INT) | RecordDate(DATE) | Temperature(INT) |
-- +---------+------------------+------------------+
-- |       1 |       2015-01-01 |               10 |
-- |       2 |       2015-01-02 |               25 |
-- |       3 |       2015-01-03 |               20 |
-- |       4 |       2015-01-04 |               30 |
-- +---------+------------------+------------------+
-- For example, return the following Ids for the above Weather table:
--
-- +----+
-- | Id |
-- +----+
-- |  2 |
-- |  4 |
-- +----+

-- 执行用时 : 711 ms, 在Rising Temperature的MySQL提交中击败了53.31% 的用户

SELECT
	w2.Id AS Id
FROM
	Weather w1
	INNER JOIN Weather w2
WHERE
	datediff( w2.RecordDate, w1.RecordDate ) = 1
	AND w2.Temperature > w1.Temperature;