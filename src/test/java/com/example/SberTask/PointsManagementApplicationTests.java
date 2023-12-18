@SpringBootTest
class PointsManagementApplicationTests {

	@Test
	public void testAddPoints() {

		ClientRepository clientRepository = Mockito.mock(ClientRepository.class);

		// Создаем объект сервиса и передаем в него мок репозитория
		PointService pointService = new PointServiceImpl(clientRepository);

		// Создаем тестового клиента
		Client client = new Client();
		client.setId(1L);
		client.setName("John Doe");
		client.setPoints(100);

		// Кол-во баллов, которые мы хотим добавить
		int amount = 50;

		// Метод addPoints должен вызывать соответствующий метод репозитория и
		// увеличивать баллы клиента на указанное кол-во
		Mockito.when(clientRepository.findById(1L)).thenReturn(java.util.Optional.of(client));
		pointService.addPoints(1L, amount);

		// Проверяем, что баллы клиента были увеличены на указанное кол-во
		assertEquals(150, client.getPoints());
	}

	@Test
	public void testDeductPoints() {
		// Создаем мок объект репозитория
		ClientRepository clientRepository = Mockito.mock(ClientRepository.class);

		// Создаем объект сервиса и передаем в него мок репозитория
		PointService pointService = new PointServiceImpl(clientRepository);

		// Создаем тестового клиента
		Client client = new Client();
		client.setId(1L);
		client.setName("John Doe");
		client.setPoints(100);

		// Кол-во баллов, которые мы хотим списать
		int amount = 50;

		// Метод deductPoints должен вызывать соответствующий метод репозитория и
		// уменьшать баллы клиента на указанное кол-во
		Mockito.when(clientRepository.findById(1L)).thenReturn(java.util.Optional.of(client));
		pointService.deductPoints(1L, amount);

		// Проверяем, что баллы клиента были уменьшены на указанное кол-во
		assertEquals(50, client.getPoints());
	}

}
