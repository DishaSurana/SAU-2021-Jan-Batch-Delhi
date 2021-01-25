
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.


/* === import statement violation ===
  1.  user defined modules should be declared/imported after the default modules from react libraries
  2.  leave one empty line between third party imports and application/user-defined module imports.
  3.  list import lines alphabetized by the module.
  import Violated Lines: 14-15, 17, 18, 20-25, 27-28, 40
*/
import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';

import { WatcherResult } from 'conduit-view'; // components never used should not be imported
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';

import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';

// Component names should start with upper camel case and unused imports should be removed
import { selectedNoteSelector } from '../../src/selectors/notesSelector';
import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';


// unnecessary whitespaces and blanks should be omitted

/*
  1.  export statements are usually mentioned together at the end of the document 
  2.  constants or identifiers should be in lower camel case
*/
export const NoteListSize = 500;

/*
  1.  All the constants should be declared at 1 place TOGETHER before the actual functionality
  2.  AnotherCOnst - Constants should be defined in lower camel case form.
*/
const AnotherCOnst = 0.7;

// all the import statements should be together at the top
import { useSelector } from 'react-redux';

// all the constants should be declared at 1 place TOGETHER before the actual functionality
const initialStartIndex = 0;
const initialStartKey = null;
const debugPagination = false;

/* 
  1.  Too long function name and function name/identifiers are in lower camel case form
  2.  Bad intentation in this function
*/
export const UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp = (
  filters, sort, disablePagination, skip: boolean = false,
) => {
  const x = useSelector(isReminderSelector);

  // setCurrPageKey - by convention update state function should be named as: setCurrPage
  const [currPage, setCurrPageKey] = useState<null | string>(null);
  const [startIndex, setStartIndex] = useState(initialStartIndex);

  // TOTALNOTES - constants and identifiers should be declared in lower camel case
  const TOTALNOTES = useRef<number>(0);

  // CURRENT_PAGE - constants and identifiers should be declared in lower camel case
  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );

  // may be syntax & logical error - not sure about nullish coalescing operator
  const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;
  const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;

  // Indentation issues
  const prevPageSize =
    numPriorItems < NoteListSize ? numPriorItems : NoteListSize;
  const shouldPrevPageLoad =
    CURRENT_PAGE.data != null && CURRENT_PAGE.data?.numPriorItems > 0 && !disablePagination;

  // Bad indentation while defining result
  const randomFunction = useMemo(() => {
    let innerlist = CURRENT_PAGE.data
      .concat(
        addDebugInfo(CURRENT_PAGE?.data ?? [], {
          pageName: 'current',
          cached: CURRENT_PAGE === null,
        })
      )
    return innerlist;
  }, [
    disablePagination,
    startIndex,
    CURRENT_PAGE,
    isCurrentPageEmpty,
  ]);

  // Bad indentation while defining result
  const result = useMemo(
    () => ({
      ...CURRENT_PAGE.data,
    }),
    [
      CURRENT_PAGE
    ]
  );
  return result;
};

// selectedID? - should be in camel case and '?' seems to be a typo
function createPlaceholders(count: number, selectedID?: string | null): Result {
  const placeholders: Array<Record<string, unknown>> = new Array(count);
  placeholders
    .fill(
      {
        id: selectedID,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      0,
      1
    )
    .fill(
      {
        id: undefined,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      1,
      count
    );
  return (placeholders as unknown) as Result;
}

// Bad indentation in the function definition
function addDebugInfo(
  list: Result,
  debugInfo: {
    pageName: PageName;
    cached: boolean;
  }
): Result {
  if (debugPagination) {
    return list.map(item => ({ ...item, debugInfo }));
  }
  return list;
}
