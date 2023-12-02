import {Pipe, PipeTransform} from '@angular/core';
import {DictionaryEntryResponse} from '../model/dictionary-entry-response';

@Pipe({
  name: 'dictionaryTranslator'
})
export class DictionaryTranslatorPipe implements PipeTransform {

  transform(key: any, dictionaries: DictionaryEntryResponse[]): any {
    if (!key || !dictionaries) {
      return '';
    }
    const value: string = dictionaries.find(entry => entry.key === key).value
    return value ? value : '';
  }

}
