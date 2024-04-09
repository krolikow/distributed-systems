from google.protobuf.internal import containers as _containers
from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

ART_SHOW: EventType
CLUB_PARTY: EventType
CONCERT: EventType
DESCRIPTOR: _descriptor.FileDescriptor
FESTIVAL: EventType
FILM_SHOW: EventType
FOOTBALL: EventType

class Address(_message.Message):
    __slots__ = ["city", "country", "streetAddress", "zipCode"]
    CITY_FIELD_NUMBER: _ClassVar[int]
    COUNTRY_FIELD_NUMBER: _ClassVar[int]
    STREETADDRESS_FIELD_NUMBER: _ClassVar[int]
    ZIPCODE_FIELD_NUMBER: _ClassVar[int]
    city: str
    country: str
    streetAddress: str
    zipCode: str
    def __init__(self, country: _Optional[str] = ..., city: _Optional[str] = ..., zipCode: _Optional[str] = ..., streetAddress: _Optional[str] = ...) -> None: ...

class Event(_message.Message):
    __slots__ = ["address", "description", "placesNumber", "type"]
    ADDRESS_FIELD_NUMBER: _ClassVar[int]
    DESCRIPTION_FIELD_NUMBER: _ClassVar[int]
    PLACESNUMBER_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    address: Address
    description: str
    placesNumber: int
    type: _containers.RepeatedScalarFieldContainer[EventType]
    def __init__(self, description: _Optional[str] = ..., address: _Optional[_Union[Address, _Mapping]] = ..., placesNumber: _Optional[int] = ..., type: _Optional[_Iterable[_Union[EventType, str]]] = ...) -> None: ...

class SubscribeRequest(_message.Message):
    __slots__ = ["country", "type"]
    COUNTRY_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    country: str
    type: _containers.RepeatedScalarFieldContainer[EventType]
    def __init__(self, country: _Optional[str] = ..., type: _Optional[_Iterable[_Union[EventType, str]]] = ...) -> None: ...

class EventType(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []
