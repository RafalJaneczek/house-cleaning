import {PageRequest} from '../../core/model/page-request';

export interface CleaningRequest extends PageRequest {
  userId: number;
  roomName: string;
}
