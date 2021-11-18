import {Account} from './Account';
import {Gender} from './Gender';

export interface Customer {
  customerId: number;
  customerName: number;
  flag: number;
  customerPhone: string;
  CustomerEmail: string;
  customerAddress: string;
  account: Account;
  gender: Gender;
}
