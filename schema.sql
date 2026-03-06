CREATE TABLE test_results (
    id SERIAL PRIMARY KEY,
    test_name VARCHAR(100),
    result VARCHAR(20),
    run_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);