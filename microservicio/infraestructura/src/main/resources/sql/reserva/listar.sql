select r.idReserva,r.identificacionUsuario,r.nombreUsuario,r.fechaReserva,r.fechaCreacion,th.tipoHabitacion,tu.tipoUsuario
from reserva r join tipo_habitacion th on r.idTipoHabitacion = th.idTipoHabitacion
join tipo_usuario tu on r.idTipoUsuario = tu.idTipoUsuario