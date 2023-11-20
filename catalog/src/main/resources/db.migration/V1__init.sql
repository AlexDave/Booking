create table apartments (
                            id                      bigint primary key,
                            price_for_day           varchar(255),
                            city                    varchar(255),
                            address                 varchar(255),
                            is_pets_friendly        boolean,
                            is_kids_friendly        boolean

);
insert into apartments (price_for_day, city, address, is_pets_friendly, is_kids_friendly) values
                                                                                              ('1500', 'Moscow', 'Lenin st', true, false),
                                                                                              ('1600', 'Moscow', 'Kutuzovski av.', true, true),
                                                                                              ('2000', 'Paris', 'Ulians st.', false, false),
                                                                                              ('100', 'Paris', 'Monmart av.', false, true),
                                                                                              ('300000', 'Istambul', 'Noname st.', true, true)

