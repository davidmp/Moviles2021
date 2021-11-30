part of 'persona_bloc.dart';
abstract class PersonaEvent{
  final ModeloPersona persona;
  const PersonaEvent({this.persona});
}
class ListarPersonaEvent extends PersonaEvent{ ListarPersonaEvent(); }
class DeletePersonaEvent extends PersonaEvent{
  DeletePersonaEvent({@required ModeloPersona persona}):super(persona: persona);
}
class UpdatePersonaEvent extends PersonaEvent{
  UpdatePersonaEvent({@required ModeloPersona persona}):super(persona: persona);
}
class CreatePersonaEvent extends PersonaEvent{
  CreatePersonaEvent({@required ModeloPersona persona}):super(persona: persona);
}