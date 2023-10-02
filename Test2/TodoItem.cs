using System.ComponentModel.DataAnnotations;

namespace TodoList.Models
{
    public class TodoItem
    {
        public int Id { get; set; }

        [Required]
        public string Task { get; set; }

        public bool IsComplete { get; set; }
    }
}
