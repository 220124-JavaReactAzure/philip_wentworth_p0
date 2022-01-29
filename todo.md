# TODO

## DAOS
- CrudDAO abstract class
- CharacterDAO
- UserDAO

## Exceptions
- InvalidStatisticValueException
- InvalidCharacterNameException
- InvalidUsernameException
- InvalidEmailException
- UsernameAlreadyExistsException
- EmailAlreadyExistsException

## Menus
- Menu abstract class (getName, getRoute, render)
- WelcomeMenu
- UserRegisterMenu
- UserLoginMenu
- CharacterGenerateMenu
- CharacterListMenu
- StatisticModifyMenu
- CharacterCompareMenu

## Models
- Statistic (statisticName, statisticValue)
- MyCharacter (characterName, statistics[6], userID)
- User (id, userName, password, email)

## Services
- StatisticService (rollStatistic, isStatisticValid)
- MyCharacterService (generateMyCharacter, updateStatistic, viewMyCharacter, compareMyCharacters, isCharacterNameValid)
- UserService (registerNewUser, authenticateUser, isUserValid, isUsernameValid, isEmailValid, isStatisticValid)

## Util
- AppState (public void startup, public static void shutdown)
- Collection interface (add, contains, isEmpty, remove(index), remove(element), size)
- ArrayList implements Collection
- MenuRouter (addMenu, transfer)
