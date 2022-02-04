# TODO

## DAOS
- DONE CrudDAO abstract class
- DONE CharacterDAO
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
- DONE UserRegisterMenu (userService)
- DONE UserLoginMenu (userService)
- DONE UserDashboardMenu (userService)
- DONE CharacterGenerateMenu (myCharacterService)
- DONE CharacterListMenu (myCharacterService)
- DONE CharacterModifyMenu (myCharacterService)
- DONE CharacterCompareMenu (myCharacterService)

## Models
- DONE MyCharacter (id, characterName, statistics[], userID)
- DONE User (userName, password, email)

## Services
- DONE MyCharacterService (generateMyCharacter, dumpStatistic, compareMyCharacters, isCharacterNameValid, rollStatistic, isStatisticValid, printCharacterStatisticLine)
- DONE UserService (registerNewUser, authenticateUser, isUserValid, isUsernameValid, isEmailValid)

## Util
- DONE AppState (public void startup, public static void shutdown)
- DONE Collection interface (add, contains, isEmpty, remove(element), size)
- DONE MyList interface (get)
- DONE MyArrayList implements List
- DONE MenuRouter (addMenu, transfer)

## Logging
- DONE DAOs
- DONE Menus
- DONE Exceptions

## Testing
- UserService
- MyCharacterService
