INSERT INTO public.match(id, date, isfinished, team_one_name , team_two_name)
VALUES (nextval('matchsequence'), to_timestamp('30-06-2018 16:00', 'DD-MM-YYYY HH24:MI'), false, 'Francja', 'Argentyna');
INSERT INTO public.match(id, date, isfinished, team_one_name , team_two_name)
VALUES (nextval('matchsequence'), to_timestamp('30-06-2018 20:00', 'DD-MM-YYYY HH24:MI'), false, 'Urugwaj', 'Portugalia');
INSERT INTO public.match(id, date, isfinished, team_one_name , team_two_name)
VALUES (nextval('matchsequence'), to_timestamp('01-07-2018 16:00', 'DD-MM-YYYY HH24:MI'), false, 'Hiszpania', 'Rosja');
INSERT INTO public.match(id, date, isfinished, team_one_name , team_two_name)
VALUES (nextval('matchsequence'), to_timestamp('01-07-2018 20:00', 'DD-MM-YYYY HH24:MI'), false, 'Chorwacja', 'Dania');
INSERT INTO public.match(id, date, isfinished, team_one_name , team_two_name)
VALUES (nextval('matchsequence'), to_timestamp('02-07-2018 16:00', 'DD-MM-YYYY HH24:MI'), false, 'Brazylia', 'Meksyk');
INSERT INTO public.match(id, date, isfinished, team_one_name , team_two_name)
VALUES (nextval('matchsequence'), to_timestamp('02-07-2018 20:00', 'DD-MM-YYYY HH24:MI'), false, 'Belgia', 'Japonia');
INSERT INTO public.match(id, date, isfinished, team_one_name , team_two_name)
VALUES (nextval('matchsequence'), to_timestamp('03-07-2018 16:00', 'DD-MM-YYYY HH24:MI'), false, 'Szwecja', 'Szwajcaria');
INSERT INTO public.match(id, date, isfinished, team_one_name , team_two_name)
VALUES (nextval('matchsequence'), to_timestamp('03-07-2018 20:00', 'DD-MM-YYYY HH24:MI'), false, 'Kolumbia', 'Anglia');
commit;
