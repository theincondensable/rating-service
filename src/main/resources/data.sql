INSERT INTO USER (city, country, street, zipcode, email, firstname, lastname, phone_number, created_on,
                  last_updated_on)
VALUES ('Tehran', 'Iran', 'Shariati', '19191919',
        'applemanager@gmail.com', 'apple', 'manager', '09001000000',
        CURRENT_TIMESTAMP, null);

# INSERT INTO USER (city, country, street, zipcode, email, firstname, lastname, phone_number, created_on,
#                   last_updated_on)
# VALUES ('Dearborn', 'US', '18900', '48126',
#         'fordmanager@gmail.com', 'ford', 'manager', '09001000001',
#         CURRENT_TIMESTAMP, null);

INSERT INTO PROVIDER(city, country, street, zipcode, name, manager_id)
VALUES ('California', 'US', 'One Apple Park Way', '95014', 'apple', 1);

# INSERT INTO PROVIDER(city, country, street, zipcode, name, managers)
# VALUES ('Dearborn', 'US', '1 American Rd', '48126', 'apple', 2);

INSERT INTO PRODUCT(category, name, color, provider_id, is_votable, is_commentable, is_open_to_all, created_on, last_updated_on)
VALUES ('phone', 'iPhone 13 Pro Max 256GB', 'Midnight Blue', 1, true, true, true, CURRENT_TIMESTAMP, null);

INSERT INTO PRODUCT(category, name, color, provider_id, is_votable, is_commentable, is_open_to_all, created_on, last_updated_on)
VALUES ('phone', 'iPhone 14 Pro Max 512GB', 'Space Black', 1, true, false, true, CURRENT_TIMESTAMP, null);

INSERT INTO PRODUCT(category, name, color, provider_id, is_votable, is_commentable, is_open_to_all, created_on, last_updated_on)
VALUES ('smart watch', 'Apple Watch Ultra 2 49mm', 'Indigo', 1, false, true, false, CURRENT_TIMESTAMP, null);