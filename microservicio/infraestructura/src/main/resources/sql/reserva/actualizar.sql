update reserva
set identificacionUsuario = :identificacionUsuario,
	nombreUsuario = :nombreUsuario,
	fechaReserva = :fechaReserva,
	fechaCreacion = :fechaCreacion,
	valorAPagar = :valorAPagar,
	idTipoHabitacion = :idTipoHabitacion,
	idTipoUsuario = :idTipoUsuario
where id = :id