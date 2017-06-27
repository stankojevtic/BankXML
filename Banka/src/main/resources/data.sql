insert into TSWIFTIRacun(obracunski_racun, swift) values('333333333333333333', 'UNIC1278');
insert into TSWIFTIRacun(obracunski_racun, swift) values('444444444444444444', 'VOJV12NS');

insert into Banka(port, racun_id) values ('9992', 1);
insert into Banka(port, racun_id) values ('9993', 2);

insert into TFirma(naziv, adresa, pib, port, racun, banka_id, novac) values ('Unicredit','gl','123','9990', '111111111111111111', 1, 25000);
insert into TFirma(naziv, adresa, pib, port, racun, banka_id, novac) values ('Vojvodjanska','gl','456','9991', '222222222222222222' ,2, 20000000);

insert into TPodaciORacunu(racun, model, poziv_na_broj) values ('111111111111111111', 97, '25-65-789');
insert into TPodaciORacunu(racun, model, poziv_na_broj) values ('222222222222222222', 95, '12-34-567');