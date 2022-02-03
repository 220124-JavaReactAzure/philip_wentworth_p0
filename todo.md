# TODO

## DAOS
- DONE CrudDAO abstract class
- CharacterDAO
- DONE UserDAO

## Exceptions
- DONE InvalidStatisticValueException
- DONE InvalidCharacterNameException
- DONE InvalidUsernameException
- DONE InvalidEmailException
- DONE UsernameAlreadyExistsException
- DONE EmailAlreadyExistsException

## Menus
- DONE Menu abstract class (getName, getRoute, render)
- DONE WelcomeMenu
- UserRegisterMenu
- UserLoginMenu
- UserDashboardMenu
- CharacterGenerateMenu
- CharacterListMenu
- StatisticModifyMenu
- CharacterCompareMenu

## Models
- DONE MyCharacter (id, characterName, statistics[], userID)
- DONE User (id, userName, password, email)

## Services
- DONE MyCharacterService (generateMyCharacter, dumpStatistic, compareMyCharacters, isCharacterNameValid, rollStatistic, isStatisticValid, printCharacterStatisticLine)
- DONE UserService (registerNewUser, authenticateUser, isUserValid, isUsernameValid, isEmailValid)

## Util
- DONE AppState (public void startup, public static void shutdown)
- DONE Collection interface (add, contains, isEmpty, remove(element), size)
- DONE MyList interface (get)
- DONE MyArrayList implements List
- DONE MenuRouter (addMenu, transfer)
