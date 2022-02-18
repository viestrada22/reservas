create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table tipo_habitacion (
  id int(11) not null auto_increment,
  tipoHabitacion varchar(100) not null,
  primary key (id)
);

create table tipo_usuario (
  id int(11) not null auto_increment,
  tipoUsuario varchar(100) not null,
  primary key (id)
);

create table precio (
  id int(11) not null auto_increment,
  precioSemana int(32) not null,
  precioFinDeSemana int(32) not null,
  idTipoHabitacion int(11) not null,
  primary key (id)
);

alter table precio add constraint fk_tipo_habitacion_precio foreign key(idTipoHabitacion) references tipo_habitacion(id);

create table reserva (
  id int(11) not null auto_increment,
  identificacionUsuario varchar(60) not null,
  nombreUsuario varchar(60) not null,
  fechaReserva date not null,
  fechaCreacion date not null,
  valorAPagar int(32) not null,
  idTipoHabitacion int(11) not null,
  idTipoUsuario int(11) not null,
  primary key (id)
);

alter table reserva add constraint fk_tipo_habitacion_reserva foreign key(idTipoHabitacion) references tipo_habitacion(id);
alter table reserva add constraint fk_tipo_usuario_reserva foreign key(idTipoUsuario) references tipo_usuario(id);

-- realizar las inserciones en la tabla tipo_usuario
insert into tipo_usuario (tipoUsuario) values('casual');
insert into tipo_usuario (tipoUsuario) values('frecuente');
insert into tipo_usuario (tipoUsuario) values('miembro');

-- insertar datos en la tabla tipo_habitacion
insert into tipo_habitacion (tipoHabitacion) values('sencilla');
insert into tipo_habitacion (tipoHabitacion) values('especial');
insert into tipo_habitacion (tipoHabitacion) values('suite');

-- insertar datos en la tabla precio
insert into precio (precioSemana, precioFinDeSemana, idTipoHabitacion) values(180000, 260000, 1);
insert into precio (precioSemana, precioFinDeSemana, idTipoHabitacion) values(390000, 560000, 2);
insert into precio (precioSemana, precioFinDeSemana, idTipoHabitacion) values(650000, 850000, 3);