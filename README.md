#Rapport TP JaxRS

Appointment:
	GET:
		//Récupère un appointment grâce à son id
		getAppointmentById(Long appointmentId)
	POST:
		//Permet de créer un rendez-vous en liant un professionel à se rendez-vous grâce à l'id du professionel
		createAppointment(Long professionalId, int dateAppointment, int durationAppointment)
		
Patient:
	GET:
		//Récupère un patient grâce à son id
		getPatientById(Long patientId)
		
Professional:
	GET:
		//Récupère un professionel grâce à son id
		getProfessionalById(Long professionalId)
		//Permet de récupérer tout les rendez-vous lié à un professionel
		getAllAppointmentReserved(Long id)
