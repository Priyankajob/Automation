Feature:Validating createuser,updateuser,getuser and delete
  Background:
    Given Lets Start background

  @Before
  @After



  @Test(priority=0)
  Scenario: Get user
      Given Load Property File
       Given Get User

  @Test(priority=1)
  Scenario: Validating Create User
    When Create User
  @Test(priority=2)
  Scenario: Validating Update user
    Then Update user
  @Test(priority=3)
  Scenario: Get user by id
    Then Get user by id

  @Test(priority=4)
  Scenario: Validating Delete user user
    Then Delete user

