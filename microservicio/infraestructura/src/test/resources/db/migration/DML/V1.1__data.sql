insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());

insert into reserva (id, identificacionUsuario, nombreUsuario, fechaReserva, fechaCreacion, valorAPagar, idTipoHabitacion, idTipoUsuario)
values (1, '123456789', 'test', '2022-02-17', '2022-02-16', 250000, 1, 1);
insert into reserva (id, identificacionUsuario, nombreUsuario, fechaReserva, fechaCreacion, valorAPagar, idTipoHabitacion, idTipoUsuario)
values (2, '12345678', 'test1', '2022-02-18', '2022-02-17', 260000, 1, 1);
insert into reserva (id, identificacionUsuario, nombreUsuario, fechaReserva, fechaCreacion, valorAPagar, idTipoHabitacion, idTipoUsuario)
values (3, '1234567', 'test2', '2022-02-18', '2022-02-16', 270000, 2, 2);
insert into reserva (id, identificacionUsuario, nombreUsuario, fechaReserva, fechaCreacion, valorAPagar, idTipoHabitacion, idTipoUsuario)
values (4, '123456', 'test3', '2022-02-19', '2022-02-17', 280000, 3, 3);
insert into reserva (id, identificacionUsuario, nombreUsuario, fechaReserva, fechaCreacion, valorAPagar, idTipoHabitacion, idTipoUsuario)
values (5, '12345', 'test4', '2022-02-20', '2022-02-16', 290000, 3, 3);