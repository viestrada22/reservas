SELECT p.id, p.precioSemana, p.precioFinDeSemana, p.idTipoHabitacion from precio p join tipo_habitacion th on p.idTipoHabitacion = th.id where p.idTipoHabitacion = :idTipoHabitacion