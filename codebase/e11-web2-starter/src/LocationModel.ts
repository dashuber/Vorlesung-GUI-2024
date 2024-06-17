export class LocationModel {
  private _id?: string;
  private _name?: string;

  private _label?: string;
  private _type?: string;
  private _subType?: string;
  private _since?: Date;
  private _active?: boolean;

  private _street?: string;
  private _streetNumber?: string;
  private _zip?: string;
  private _city?: string;
  private _notes?: string;

  get id(): string | undefined {
    return this._id;
  }

  set id(value: string | undefined) {
    this._id = value;
  }

  get name(): string | undefined {
    return this._name;
  }

  set name(value: string | undefined) {
    this._name = value;
  }

  get label(): string | undefined {
    return this._label;
  }

  set label(value: string | undefined) {
    this._label = value;
  }

  get type(): string | undefined {
    return this._type;
  }

  set type(value: string | undefined) {
    this._type = value;
  }

  get subType(): string | undefined {
    return this._subType;
  }

  set subType(value: string | undefined) {
    this._subType = value;
  }

  get since(): Date | undefined {
    return this._since;
  }

  set since(value: Date | undefined) {
    this._since = value;
  }

  get active(): boolean | undefined {
    return this._active;
  }

  set active(value: boolean | undefined) {
    this._active = value;
  }

  get street(): string | undefined {
    return this._street;
  }

  set street(value: string | undefined) {
    this._street = value;
  }

  get streetNumber(): string | undefined {
    return this._streetNumber;
  }

  set streetNumber(value: string | undefined) {
    this._streetNumber = value;
  }

  get zip(): string | undefined {
    return this._zip;
  }

  set zip(value: string | undefined) {
    this._zip = value;
  }

  get city(): string | undefined {
    return this._city;
  }

  set city(value: string | undefined) {
    this._city = value;
  }

  get notes(): string | undefined {
    return this._notes;
  }

  set notes(value: string | undefined) {
    this._notes = value;
  }

  toString(): string {
    return JSON.stringify(this);
  }
}
