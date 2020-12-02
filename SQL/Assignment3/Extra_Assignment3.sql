USE adventureworks;
-- EX1: SubQuery
-- Q1:
SELECT 
    `Name`
FROM
    Product
WHERE
    ProductsubcategoryID = (SELECT 
            ProductsubcategoryID
        FROM
            Productsubcategory
        WHERE
            `name` = 'Saddles');

-- Q2:
SELECT 
    `Name`
FROM
    Product
WHERE
    ProductsubcategoryID IN (SELECT 
            ProductsubcategoryID
        FROM
            Productsubcategory
        WHERE
            `name` like 'Bo%');

-- Q3:
select * from product;
SELECT 
`name`
FROM
    Product
WHERE
    ListPrice = (SELECT 
            MIN(ListPrice)
        FROM
            Product
        WHERE
            ProductsubcategoryID IN (SELECT 
                    ProductsubcategoryID
                FROM
                    Productsubcategory
                WHERE
                    ProductsubcategoryID = 3));

-- EX2: JOIN nhieu bảng
-- Q1:
SELECT 
    countryregion.name AS Country,
    stateprovince.name AS Province
FROM
    stateprovince
        LEFT JOIN
    countryregion ON countryregion.CountryRegionCode = stateprovince.CountryRegionCode;

select * from salesperson;
select * from salesorderheader;

-- Q2:: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada
SELECT 
    c.name AS Country, s.name AS Province
FROM
    stateprovince s
        LEFT JOIN
    countryregion c ON c.CountryRegionCode = s.CountryRegionCode
WHERE
    c.name IN ('Germany' , 'Canada');

-- Q3:

SELECT 
    aoh.SalesOrderID,
    aoh.OrderDate,
    sp.SalesPersonID,
    sp.Bonus,
    sp.SalesYTD
FROM
    salesorderheader aoh
        JOIN
    salesperson sp ON aoh.SalesPersonID = sp.SalesPersonID;

-- Q4:Sử dụng câu query, thêm cột JobTitle and xóa cột SalesPersonID và
-- BusinessEntityID.
SELECT 
    aoh.SalesOrderID,
    aoh.OrderDate,
    e.Title,
    sp.Bonus,
    sp.SalesYTD
FROM
    ((salesorderheader aoh
    JOIN salesperson sp ON aoh.SalesPersonID = sp.SalesPersonID)
    JOIN Employee e ON aoh.SalesPersonID = e.EmployeeID);
