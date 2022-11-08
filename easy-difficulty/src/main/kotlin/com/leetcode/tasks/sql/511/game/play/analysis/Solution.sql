-- 511. Game Play Analysis I
-- https://leetcode.com/problems/game-play-analysis-i/

SELECT
    player_id,
    min(event_date) as first_login
FROM Activity
GROUP BY player_id