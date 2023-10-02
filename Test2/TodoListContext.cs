using Microsoft.EntityFrameworkCore;

namespace TodoList.Data
{
    public class TodoListContext : DbContext
    {
        public TodoListContext(DbContextOptions<TodoListContext> options) : base(options)
        {
        }

        public DbSet<TodoList.Models.TodoItem> TodoItems { get; set; }
    }
}
