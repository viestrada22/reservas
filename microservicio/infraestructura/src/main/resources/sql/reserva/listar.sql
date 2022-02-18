select r.id,r.identificacionUsuario,r.nombreUsuario,r.fechaReserva,r.fechaCreacion,r.valorAPagar,r.idTipoHabitacion,r.idTipoUsuario
from reserva r join tipo_habitacion th on r.idTipoHabitacion = th.id
join tipo_usuario tu on r.idTipoUsuario = tu.id