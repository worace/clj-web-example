-- name: all-examples
-- Fetches all records from examples table
SELECT * from examples

-- name: create-example<!
INSERT INTO examples
( name, admin, last_login, pass )
VALUES ( :name, :admin, :last_login, :pass )
