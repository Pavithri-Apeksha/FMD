let tasks = [];
let currentTaskIndex = null; 

window.onload = function () {
    // Display today's date
    const todayDateElement = document.getElementById('todayDate');
    const today = new Date();
    const formattedDate = today.toDateString(); 
    todayDateElement.textContent = formattedDate; 

    // Display current month in the <h3> tag
    const currentMonthElement = document.getElementById('currentMonth');
    const options = { month: 'long', year: 'numeric' }; 
    currentMonthElement.textContent = today.toLocaleDateString('en-US', options); 

    // Generate calendar for the current month
    generateCalendar(today); 
}

function addTask() {
    const taskInput = document.getElementById('taskInput');
    const task = taskInput.value.trim();

    if (task) {
        tasks.push({ text: task, completed: false });
        taskInput.value = '';
        renderTasks();
    }
}

function renderTasks() {
    const taskList = document.getElementById('taskList');
    taskList.innerHTML = '';

    tasks.forEach((task, index) => {
        const li = document.createElement('li');

        const taskText = document.createElement('span');
        taskText.className = 'task-text'; 
        taskText.textContent = task.text;
        if (task.completed) {
            li.classList.add('completed');
        }

        const checkbox = document.createElement('input');
        checkbox.type = 'checkbox';
        checkbox.checked = task.completed;
        checkbox.className = 'checkbox'
        checkbox.addEventListener('change', () => toggleTaskCompletion(index));

        const editButton = document.createElement('button');
        editButton.textContent = 'Edit';
        editButton.className = 'edit';
        editButton.onclick = () => openModal(index);

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.className = 'delete';
        deleteButton.onclick = () => deleteTask(index);

        li.appendChild(checkbox);
        li.appendChild(taskText);
        li.appendChild(editButton);
        li.appendChild(deleteButton);
        taskList.appendChild(li);
    });
}

function toggleTaskCompletion(index) {
    tasks[index].completed = !tasks[index].completed;
    renderTasks();
}

function deleteTask(index) {
    if (confirm('Are you sure you want to delete this task?')) {
        tasks.splice(index, 1);
        renderTasks();
    }
}

// Open the modal for editing the task
function openModal(index) {
    currentTaskIndex = index;
    const modal = document.getElementById('editModal');
    const editTaskInput = document.getElementById('editTaskInput');
    editTaskInput.value = tasks[index].text; 
    modal.style.display = 'block';
}

// Close the modal
function closeModal() {
    const modal = document.getElementById('editModal');
    modal.style.display = 'none';
}

// Save the edited task
function saveEdit() {
    const editTaskInput = document.getElementById('editTaskInput');
    const newTaskText = editTaskInput.value.trim();

    if (newTaskText) {
        tasks[currentTaskIndex].text = newTaskText;
        renderTasks();
        closeModal(); 
    }
}

// Close modal when clicking outside of it
window.onclick = function (event) {
    const modal = document.getElementById('editModal');
    if (event.target == modal) {
        modal.style.display = 'none';
    }
}

// Generate calendar for the current month
function generateCalendar(date) {
    const calendarDiv = document.getElementById('calendar');
    calendarDiv.innerHTML = ''; 

    const month = date.getMonth(); 
    const year = date.getFullYear(); 

    const firstDay = new Date(year, month, 1).getDay(); 
    const daysInMonth = new Date(year, month + 1, 0).getDate(); 

    const calendarTable = document.createElement('table');
    const headerRow = document.createElement('tr');

    const daysOfWeek = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    daysOfWeek.forEach(day => {
        const th = document.createElement('th');
        th.textContent = day;
        headerRow.appendChild(th);
    });
    calendarTable.appendChild(headerRow);

    let dateCount = 1;

    for (let i = 0; i < 6; i++) {
        const row = document.createElement('tr');
        for (let j = 0; j < 7; j++) {
            const cell = document.createElement('td');

            if (i === 0 && j < firstDay) {
                cell.textContent = '';
            } else if (dateCount <= daysInMonth) {
                cell.textContent = dateCount;

                const today = new Date();
                if (dateCount === today.getDate() && month === today.getMonth() && year === today.getFullYear()) {
                    cell.classList.add('today'); 
                }

                dateCount++;
            } else {
                cell.textContent = '';
            }

            row.appendChild(cell);
        }
        calendarTable.appendChild(row);
        if (dateCount > daysInMonth) {
            break;
        }
    }

    calendarDiv.appendChild(calendarTable); 
}

window.onload = function () {
    const today = new Date();
    generateCalendar(today); 

    const currentMonthElement = document.getElementById('currentMonth');
    const options = { month: 'long', year: 'numeric' };
    currentMonthElement.textContent = today.toLocaleDateString('en-US', options);

    const todayDateElement = document.getElementById('todayDate');
    todayDateElement.textContent = today.toLocaleDateString('en-US'); 
}