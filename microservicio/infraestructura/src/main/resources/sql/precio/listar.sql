select p.idPrecio, p.precioSemana, p.precioFinDeSemana, th.idTipoHabitacion from precio p join tipo_habitacion th on p.idTipoHabitacion = th.idTipoHabitacion;