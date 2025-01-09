Feature:Validating createuser,updateuser,getuser and delete
  Background:
    Given Lets Start background

  @Before
  @After
  @AfterMethod



@Test
  Scenario: Get user
      Given Load Property File
       Given Get User

  @Test
  Scenario: Validating Create User
    When Create User
  @Test
  Scenario: Validating Update user
    Then Update user
  @Test
  Scenario: Get user by id
    Then Get user by id


  @Test
  Scenario: validate Json
    Then validate Json

  @Test
  Scenario: Validating Delete user user
    Then Delete user

