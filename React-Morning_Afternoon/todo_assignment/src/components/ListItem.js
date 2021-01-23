import React from 'react';

class ListItem extends React.Component {

    render() {
        const { todo, index, deleteTask, duplicateTask, toggleTodoMarked } = this.props;
        return (
            <div style={{ boxShadow: "2px 3px 5px gray" }}
                class="d-flex flex-row justify-content-center list-group-item list-group-item-action my-1 col-md-8 mx-auto">
                <input class="checkbox my-auto"
                    type="checkbox"
                    checked={todo.completed}
                    onChange={() => toggleTodoMarked(index)} />

                <span class="mx-3 my-auto" style={todo.completed ? { textDecoration: 'line-through' } : { fontStyle: "italic" }}>
                    {todo.task}
                </span>


                <button class="btn btn-danger btn-sm col-md-2 small mx-2" onClick={() => deleteTask(index)}>Delete</button>
                <button class="btn btn-info btn-sm col-md-2 small mx-2" onClick={() => duplicateTask(index)}>Duplicate </button>

            </div>

        );
    }
}

export default ListItem;
